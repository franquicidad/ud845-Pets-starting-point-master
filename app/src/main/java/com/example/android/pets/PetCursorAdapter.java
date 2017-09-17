package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.R;
import com.example.android.pets.data.PetContract;

/**
 * Created by mac on 14/09/17.
 */

public class PetCursorAdapter extends CursorAdapter {

    private TextView nameText,breedText;

    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        /** find the textViews*/

        nameText=(TextView) view.findViewById(R.id.name);
        breedText=(TextView) view.findViewById(R.id.summary);

        /**Find the columns of pet atributes*/
        int nameColumnIndex= cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_NAME);
        int breedColumnIndex= cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_BREED);

        /** Read the pet attributes from the cursor for the current pet*/
        String petName=cursor.getString(nameColumnIndex);
        String petBreed=cursor.getString(breedColumnIndex);

        nameText.setText(petName);
        breedText.setText(petBreed);



    }
}