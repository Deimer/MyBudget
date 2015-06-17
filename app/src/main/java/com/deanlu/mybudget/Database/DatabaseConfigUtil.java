package com.deanlu.mybudget.Database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Deimer on 17/06/2015.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil{

    public static void main(String[] args)throws IOException, SQLException{
        writeConfigFile("ormlite_config.txt");
    }

}
