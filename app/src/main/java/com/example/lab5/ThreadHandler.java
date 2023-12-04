package com.example.lab5;

import android.content.Context;
import android.os.Message;

import com.example.lab5.db.DatabaseHandler;
import com.example.lab5.db.User;

import java.util.List;
import android.os.Handler;
import android.util.Log;

public class ThreadHandler {
    Handler t_handler;
    final Message message = Message.obtain();
    Context  context = MainActivity.getContextM2();

    ThreadHandler(Handler handler, Context context){
        this.t_handler = handler;
        //this.context = context;
    }

    DatabaseHandler db;

    public void tGetAllUser(){
        new Thread(() -> {


            Log.i("Thread", Thread.currentThread().getName());
            db = new DatabaseHandler(context);
            List<User> userList = db.getAllUsers();
            message.sendingUid = 1;
            message.obj = userList;
            t_handler.sendMessage(message);
        }).start();
    }
    public void tUserAdd(String log, String pass){
        new Thread(() -> {

            Log.i("Thread", Thread.currentThread().getName());
            db = new DatabaseHandler(context);
            String messageAdd = db.addUser(new User(log, pass));
            message.sendingUid = 2;
            message.obj = messageAdd;
            t_handler.sendMessage(message);

        }).start();
    }
    public void tGetUser(String log){
        new Thread(() -> {
            Log.i("Thread", Thread.currentThread().getName());
            db = new DatabaseHandler(context);
            String loginData = db.getUser(log);
            message.sendingUid = 3;
            message.obj = loginData;
            t_handler.sendMessage(message);
        }).start();
    }
    public void tUpdPass(String log, String pass){
        new Thread(() -> {
            Log.i("Thread", Thread.currentThread().getName());
            db = new DatabaseHandler(context);
            String messageUpd = db.updatePassword(log, pass);
            message.sendingUid = 4;
            message.obj = messageUpd;
            t_handler.sendMessage(message);
        }).start();
    }
    public void tDelUser(String log){
        new Thread(() -> {
            Log.i("Thread", Thread.currentThread().getName());
            db = new DatabaseHandler(context);
            String messageUpd = db.deleteUser(log);
            message.sendingUid = 5;
            message.obj = messageUpd;
            t_handler.sendMessage(message);
        }).start();
    }
}
