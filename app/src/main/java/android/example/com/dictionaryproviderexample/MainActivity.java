/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.example.com.dictionaryproviderexample;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.provider.UserDictionary.Words;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * This is the central activity for the Provider Dictionary Example App. The purpose of this app is
 * to show an example of accessing the {@link Words} list via its' Content Provider.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);
        ListView l = (ListView) findViewById(R.id.listView);
        String[] COLUMNS_TO_BE_BOUND ={Words.WORD, Words.FREQUENCY};
        int[] layouts ={android.R.id.text1, android.R.id.text2};
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.two_line_list_item,
                    cursor,
                    COLUMNS_TO_BE_BOUND,
                    layouts,
                    0);
            l.setAdapter(adapter);
        }
    }
}
