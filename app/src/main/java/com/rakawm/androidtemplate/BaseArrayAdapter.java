/*
 * Copyright (C) 2015 Rakawm.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rakawm.androidtemplate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Base Array Adapter class.
 */
public abstract class BaseArrayAdapter<T> extends BaseAdapter {
    private List<T> list;
    private List<T> shown;
    public abstract ViewHolder<T> createHolder();

    /**
     * Default constructor.
     */
    public BaseArrayAdapter(){
        super();
        this.list = new ArrayList<>();
        this.shown = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return shown.size();
    }

    @Override
    public T getItem(int position) {
        return shown.get(position);
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        ViewHolder<T> holder = null;
        if(view==null){
            holder = createHolder();
            view = holder.createView(parent.getContext());
            view.setTag(holder);
        } else {
            holder = extractHolder(view);
        }
        holder.bind(pos, getItem(pos));
        return view;
    }

    @SuppressWarnings("unchecked")
    public ViewHolder<T> extractHolder(View view) {
        return (ViewHolder<T>) view.getTag();
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        if (list == null) {
            this.list = Collections.<T>emptyList();
        } else {
            this.list = list;
        }
    }

    public void prependList(List<T> list) {
        this.list.addAll(0, list);
    }

    public void appendList(List<T> list) {
        this.list.addAll(list);
    }

    @Override
    public void notifyDataSetChanged() {
        shown = list;
        super.notifyDataSetChanged();
    }

    // class holder
    public static abstract class ViewHolder<T> {
        public abstract View createView(Context context);

        public abstract void bind(int pos, T object);
    }
}
