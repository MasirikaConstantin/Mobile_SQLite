package com.example.sqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.sqllite.R; // Assurez-vous que le package est correct


import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private Context mContext;
    private List<User> userList;

    public UserAdapter(Context context, List<User> list) {
        super(context, 0, list);
        mContext = context;
        userList = list;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Vérifiez si nous devons créer une nouvelle vue ou réutiliser une vue existante
        if (convertView == null) {
            // Assurez-vous que user_item.xml existe dans le répertoire res/layout
            convertView = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);
        }

        // Obtenez l'utilisateur pour la position actuelle
        User currentUser = userList.get(position);

        // Assurez-vous que userName est un ID valide dans user_item.xml
        TextView nameTextView = convertView.findViewById(R.id.userName);

        // Assurez-vous que currentUser.getName() retourne une valeur valide
        if (nameTextView != null && currentUser != null) {
            nameTextView.setText(currentUser.getName());
        }

        return convertView;
    }

}
