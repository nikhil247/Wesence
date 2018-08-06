package com.firebase.nikhilmanali.wesence;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.firebase.nikhilmanali.wesence.jsonSchema.Feed;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by Nikhil Manali on 8/1/2018.
 */

public class dataAdapter extends RecyclerView.Adapter<dataAdapter.ViewHolder> {




    List<Feed> data;  // Feed list
    MainActivity context; // This will call the context of Mainactivity in which recyclerView is shown

    public dataAdapter(List<Feed> data, MainActivity context) {

       // Initialize
        this.data = data;
        this.context = context;

    }

    @Override
    public dataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflated_views_recycler, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final dataAdapter.ViewHolder holder, int position) {



        holder.videoview.setVideoPath(data.get(position).getUser().getVideoUrl()).setFingerprint(position); // set the path of video url
        holder.title.setText(data.get(position).getName());
        holder.username.setText("by: "+data.get(position).getUser().getUsername());
        Picasso.get().
                load("https://betterbydesign.s3.amazonaws.com/"+data.get(position).getUser().getVideo()+".jpg").into(holder.imageView); // use picasso lib for image from url
        holder.like.setText(data.get(position).getMeta().getReactionCount()+"");
        holder.comment_num.setText(data.get(position).getMeta().getCommentCount()+"");
        holder.views.setText(data.get(position).getMeta().getViews()+"");

      if(data.get(position).getMeta().getCommentCount()!=0){  // in some case there are no comments so disable the comment section


          holder.user_image_view.setVisibility(View.VISIBLE); // If there are comments then show comment section
          Picasso.get().
                  load(data.get(position).getComments().get(0).getUserComment().getVideoUrlComment()+".jpg").into(holder.user_image_view);// use picasso lib for image from url
          holder.username_comment.setText(data.get(position).getComments().get(0).getUserComment().getNameComment().getFull());
          holder.comment_text.setText(data.get(position).getComments().get(0).getText());
          holder.react_text.setText("React");
          holder.reply_text.setText("Reply");
          holder.month.setText("1 month ago");
          holder.see_all_comments.setText("See all comments");


      }else {

          holder.user_image_view.setVisibility(View.INVISIBLE); // If there are no comment hide the comment section
          holder.react_text.setText("");
          holder.reply_text.setText("");
          holder.month.setText("");
          holder.username_comment.setText("");
          holder.comment_text.setText(" No Comments Available ");
          holder.see_all_comments.setText("");

      }


      // Set the thumbnail image in the video.

        if(position==0){

            holder.videoview.setBackgroundResource(R.drawable.one);
        }else if(position==1){
            holder.videoview.setBackgroundResource(R.drawable.two);

        }else if(position==2){
            holder.videoview.setBackgroundResource(R.drawable.three);

        }else if(position==3){
            holder.videoview.setBackgroundResource(R.drawable.four);

        }else if(position==4){
            holder.videoview.setBackgroundResource(R.drawable.five);

        }else if(position==5){
            holder.videoview.setBackgroundResource(R.drawable.six);

        }else if(position==6){
            holder.videoview.setBackgroundResource(R.drawable.seven);

        }else if(position==7){
            holder.videoview.setBackgroundResource(R.drawable.eight);

        }else if(position==8){
            holder.videoview.setBackgroundResource(R.drawable.nine);

        }else if(position==9){
            holder.videoview.setBackgroundResource(R.drawable.ten);

        }




    }

    @Override
    public int getItemCount() {


        return data.size(); // return the size of feeds
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView,user_image_view; // All the image view
        TextView username,title,comment_num,like,views,username_comment,comment_text,react_text,reply_text,month,see_all_comments; // All the text view
        tcking.github.com.giraffeplayer2.VideoView videoview; // use online video playing library

        public ViewHolder(View view) {
            super(view);
            imageView=(ImageView) view.findViewById(R.id.image_view); // set the image of user
            videoview = (tcking.github.com.giraffeplayer2.VideoView) view.findViewById(R.id.video_view); // show the video from the feeds using url
            username=(TextView) view.findViewById(R.id.username);// name of the user who upload the video or challenge
            title = (TextView) view.findViewById(R.id.title);// title of the video or challenge
            like=(TextView) view.findViewById(R.id.num_like); // number of like in a video or challenge
            comment_num=(TextView) view.findViewById(R.id.num_comment);// number of comment
            views=(TextView) view.findViewById(R.id.view);// number of views
            user_image_view=(ImageView)view.findViewById(R.id.image_comment_view);// image of the user who comment
            username_comment=(TextView) view.findViewById(R.id.comment_username); // name of the user who comment
            comment_text=(TextView) view.findViewById(R.id.comment_text); // text of the comment
            react_text=(TextView) view.findViewById(R.id.react_text); // react text
            reply_text=(TextView) view.findViewById(R.id.reply_text);// reply text
            month=(TextView) view.findViewById(R.id.month); // date of the comment
            see_all_comments=(TextView) view.findViewById(R.id.see_comments); // A text button to see all the comments


        }
    }
}