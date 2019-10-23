package com.example.userdetails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import static com.example.userdetails.MainActivity.datums;

public class User_Details_View extends AppCompatActivity {
    private ImageView imageView,imageBtnbefore,imageBtnnext,img2;
    private TextView fullName,email,id;
    private String mFirstName,mLastName,mAvatar,mEmail;
    private Integer mId;
    private CardView cardViewZoomOut,cardViewZoomIn;
    private int mposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__details__view);
        imageView=findViewById(R.id.imgZoomOut);
        img2=findViewById(R.id.imgZoomIn);
        imageBtnbefore=findViewById(R.id.imgBtnbefore);
        imageBtnnext=findViewById(R.id.imgBtnnext);
        fullName=findViewById(R.id.fullname);
        id=findViewById(R.id.Id);
        email=findViewById(R.id.email);
        cardViewZoomOut=findViewById(R.id.cardViewzoomOut);
        cardViewZoomIn=findViewById(R.id.cardViewzoomIn);
        Intent intent = getIntent();
//        mFirstName = intent.getStringExtra("firstname");
//        mLastName = intent.getStringExtra("lastname");
//        mAvatar = intent.getStringExtra("avatar");
//        mEmail = intent.getStringExtra("email");
//        mId = intent.getStringExtra("id");
        mposition=intent.getIntExtra("position",0);
        mFirstName = datums.get(mposition).getFirstName();
        mLastName = datums.get(mposition).getLastName();
        mAvatar = datums.get(mposition).getAvatar();
        mEmail = datums.get(mposition).getEmail();
        mId = datums.get(mposition).getId();

        RequestOptions requestOptions = new RequestOptions();
        Glide.with(this)
                .load(mAvatar)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);

        Glide.with(this)
                .load(mAvatar)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(img2);

        fullName.setText(mFirstName+" "+mLastName);
        email.setText(mEmail);
        id.setText("Id: "+mId);


        imageBtnbefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mposition--;
                if (mposition<0)
                {
                    mposition=datums.size()-1;
                }
                mFirstName = datums.get(mposition).getFirstName();
                mLastName = datums.get(mposition).getLastName();
                mAvatar = datums.get(mposition).getAvatar();
                mEmail = datums.get(mposition).getEmail();
                mId = datums.get(mposition).getId();
                RequestOptions requestOptions = new RequestOptions();
                Glide.with(User_Details_View.this)
                        .load(mAvatar)
                        .apply(requestOptions)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(imageView);

                Glide.with(User_Details_View.this)
                        .load(mAvatar)
                        .apply(requestOptions)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(img2);

                fullName.setText(mFirstName+" "+mLastName);
                email.setText(mEmail);
                id.setText("Id: "+mId);

            }
        });

        imageBtnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mposition++;
                if (mposition>=datums.size())
                {
                    mposition=0;
                }
                mFirstName = datums.get(mposition).getFirstName();
                mLastName = datums.get(mposition).getLastName();
                mAvatar = datums.get(mposition).getAvatar();
                mEmail = datums.get(mposition).getEmail();
                mId = datums.get(mposition).getId();
                RequestOptions requestOptions = new RequestOptions();
                Glide.with(User_Details_View.this)
                        .load(mAvatar)
                        .apply(requestOptions)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(imageView);

                Glide.with(User_Details_View.this)
                        .load(mAvatar)
                        .apply(requestOptions)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(img2);

                fullName.setText(mFirstName+" "+mLastName);
                email.setText(mEmail);
                id.setText("Id: "+mId);

            }
        });

        cardViewZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewZoomOut.setVisibility(View.GONE);
                cardViewZoomIn.setVisibility(View.VISIBLE);
            }
        });

        cardViewZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardViewZoomIn.setVisibility(View.GONE);
                cardViewZoomOut.setVisibility(View.VISIBLE);
            }
        });

    }
}
