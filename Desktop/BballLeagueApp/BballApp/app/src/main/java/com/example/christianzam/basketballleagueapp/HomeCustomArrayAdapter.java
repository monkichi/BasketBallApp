package com.example.christianzam.basketballleagueapp;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class HomeCustomArrayAdapter extends ArrayAdapter<HomeItem> {

        Context context;
        List<HomeItem> drawerItemList;
        int layoutResID;
        MediaController mediaController;
        Bitmap bitmap;
        ProgressDialog pDialog;

        public HomeCustomArrayAdapter(Context context, int layoutResourceID,
                                          List<HomeItem> listItems) {
            super(context, layoutResourceID, listItems);
            this.context = context;
            this.drawerItemList = listItems;
            this.layoutResID = layoutResourceID;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DrawerItemHolder drawerHolder;
            View view = convertView;
            //Check if view is already inflatted
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(layoutResID, parent, false);
                drawerHolder = new DrawerItemHolder();
                drawerHolder.displayImageView = (ImageView) view.findViewById(R.id.image);
                drawerHolder.displayVideoView = (VideoView) view.findViewById(R.id.video);
                drawerHolder.captionView = (TextView) view.findViewById(R.id.team_name1);


                view.setTag(drawerHolder);

            } else {
                drawerHolder = (DrawerItemHolder) view.getTag();

            }

            HomeItem dItem = this.drawerItemList.get(position);
            if (drawerHolder.captionView != null) {
                drawerHolder.captionView.setText(dItem.getCaption());
            }
    //SET UP IMAGE VIEW
           if (dItem.videoUrl == null) {
             //Hide VideoView were showing image and caption
                //drawerHolder.displayImageView.setImageURI();
                //drawerHolder.displayVideoView.setVisibility(View.GONE);
                //Load Image using already made class
                new DownloadImageTask(drawerHolder.displayImageView).execute(dItem.getImageUrl().toString());
                //new LoadImage();
           }
            else{
               //SETS UP VIDEO VIEW
               try {
                   //Hide the imageview were showing video and caption
                   //drawerHolder.displayImageView.setVisibility(View.GONE);
                   //Set dynamic path of the video
                   drawerHolder.displayVideoView.setVideoPath(dItem.getVideoUrl().toString());
                   //Create media controller for control icons on video view
                   mediaController = new MediaController(getContext());
                   mediaController.setAnchorView(drawerHolder.displayVideoView);
                   //Assign the media controller to the assigned video view
                   drawerHolder.displayVideoView.setMediaController(mediaController);
                   drawerHolder.displayVideoView.start();


               }
               catch (Exception e) {

               }
           }
            return view;
        }
    //UI Drawer Class for quick reference of all UI components on the drawer
    private static class DrawerItemHolder {
            TextView captionView;
            ImageView displayImageView;
            VideoView displayVideoView;
        }
/*    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog();
            pDialog.setMessage("Loading Image ....");
            pDialog.show();

        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if(image != null){
                img.setImageBitmap(image);
                pDialog.dismiss();

            }else{

                pDialog.dismiss();
                Toast.makeText(MainActivity.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

            }
        }
    }*/
   //Class for getting image from the web
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        private ProgressDialog pDlg;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }


   @Override
    protected void onPreExecute() {
       // TODO Auto-generated method stub
       super.onPreExecute();
   }

        protected void onPostExecute(Bitmap result) {

            bmImage.setImageBitmap(result);
        }}
}

