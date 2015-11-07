package ru.yandex.android.andrew.englishcards.model;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import ru.yandex.android.andrew.englishcards.Constants;
import ru.yandex.android.andrew.englishcards.R;

/**
 * Created by Андрей on 24.10.2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase dataBase;
    private final Context context;

    public DBHelper(Context _context){
        super(_context, Constants.DB_NAME, null, 1);
        this.context = _context;
    }

    public void onCreate(SQLiteDatabase db){
        try {
            createDataBase();
        }catch (IOException e){
            throw new Error("Error IO", e);
        }


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public SQLiteDatabase openDataBase() throws SQLException {
        File DB_PATH = context.getExternalCacheDir();
        File dbFile = new File (DB_PATH, Constants.DB_NAME);
        dataBase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);
        return dataBase;
    }

    public void createDataBase() throws IOException{
        //get path to dir app on SDcard
        File DB_PATH = context.getExternalCacheDir();
        //create dir for DB
        DB_PATH.mkdirs();
        //check exist file DB on SDcard
        File db = new File(DB_PATH, Constants.DB_NAME);
        if (!db.exists()){
            //if file DB not exist - create empty DB file
            db.createNewFile();
            try {
                copyFromZipFile(DB_PATH, Constants.DB_NAME);
            }catch (IOException e){
                throw new Error("Error copying database", e);
            }

        }
    }

    private void copyFromZipFile(File DB_PATH, String DB_NAME) throws IOException{
        InputStream is = context.getResources().openRawResource(R.raw.database);
        File outFile = new File(DB_PATH, DB_NAME);
        OutputStream outputStream = new FileOutputStream(outFile.getAbsolutePath());
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is));
        try{
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                while ((count = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0, count);
                }
                baos.writeTo(outputStream);
            }
        } finally {
            zis.close();
            outputStream.flush();
            outputStream.close();
            is.close();
        }
    }



}
