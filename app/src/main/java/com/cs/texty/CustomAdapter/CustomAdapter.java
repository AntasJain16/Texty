package com.cs.texty.CustomAdapter;

import android.databinding.BindingAdapter;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import com.cs.texty.R;

public class CustomAdapter {
    @BindingAdapter("android:use_as_auto_complete")
    public static void toRemove(MultiAutoCompleteTextView view,Boolean tobe) {
        if (tobe) {
            String[] heros = view.getResources().getStringArray(R.array.hero_array);
            final ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, heros);
            view.setAdapter(adapter);
            view.setThreshold(1);
            view.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
            view.setHint("Working as AutoComplete");
        }
        else {
            view.setAdapter(null);
            view.setHint("Working as EditText");
        }
    }
}
