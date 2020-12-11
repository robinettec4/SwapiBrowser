package com.example.swapibrowser.activities;

import android.content.Context;
import android.content.Intent;

public class TabsHelper {

    Context context;

    public TabsHelper(Integer position, Context context){
        this.context = context;

        switch(position){
            case 0:
                goToFavorite(); break;
            case 1:
                goToRecentlyViewedActivity(); break;
            case 2:
                goToSearchActivity(); break;
            case 3:
                goToHome(); break;
            case 4:
                goToRecentActivity(); break;
            case 5:
                goToRandomPageActivity(); break;
            default:
                break;
        }
    }

    public void goToRandomPageActivity() {
        if(!(context instanceof RandomPage)){
            Intent intent = new Intent(context, RandomPage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void goToRecentActivity(){
        if(!(context instanceof RecentPage)) {
            Intent intent = new Intent(context, RecentPage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void goToSearchActivity(){
        if(!(context instanceof Search)) {
            Intent intent = new Intent(context, Search.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void goToRecentlyViewedActivity(){
        if(!(context instanceof LastVisited)) {
            Intent intent = new Intent(context, LastVisited.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void goToFavorite(){
        if(!(context instanceof FavoritePages)) {
            Intent intent = new Intent(context, FavoritePages.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void goToHome(){
        if(!(context instanceof MainActivity)) {
            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
