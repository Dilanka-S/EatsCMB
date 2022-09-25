package lk.sliiti.eatscmb.database.data;

import java.util.ArrayList;

import lk.sliiti.eatscmb.database.model.User;

public class UserData {
    private static ArrayList<User> userDataArrayList = new ArrayList<>();
    private static Boolean alreadySet = false;

    public static ArrayList<User> getUserDataArrayList() {
        while (!alreadySet){
            initialise();
            alreadySet = true;
        }
        return userDataArrayList;
    }

    public static void setUserDataArrayList(ArrayList<User> userDataArrayList) {
        UserData.userDataArrayList = userDataArrayList;
    }


    public static void initialise(){
        userDataArrayList.add(new User("dvsen","dilanka123"
                ,"Dilanka Seneviratne","No"));
        userDataArrayList.add(new User("uhgame","uvindu123"
                ,"Uvindu Gamage","No"));
    }
    public static User getUser(String username){
        User user = null;
        for (int i = 0; i < userDataArrayList.size(); i++) {
            if (username.equals(userDataArrayList.get(i).getUsername())){
                user = userDataArrayList.get(i);
            }
        }
        return user;
    }

    public static void addUser(String name, String username, String password, String logStatus){
        userDataArrayList.add(new User(username,password,name,logStatus));
    }

    public static Boolean userAlreadyExists(String username){
        Boolean confirmation = false;
        for (int i = 0; i < userDataArrayList.size(); i++) {
            if (username.equals(userDataArrayList.get(i).getUsername())) {
                confirmation = true;
            }

        }
        return confirmation;
    }




}
