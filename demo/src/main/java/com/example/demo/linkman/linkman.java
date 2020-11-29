package com.example.demo.linkman;
public class linkman {
    public String name;
    public String tel;
    public String mail;
    public String address;
    public String qq;
    //public int t = 0;
    public linkman(String name ,String tel,String mail, String address, String qq){
        this.name = name;
        this.tel = tel;
        this.mail = mail;
        this.address = address;
        this.qq = qq;
        //this.t = t;
    }

    public linkman() {

    }

    //public linkman(){}
    public String Getname(){
        return this.name;
    }
    public  String Gettel(){
        return  this.tel;
    }
    public  String Getmail(){
        return this.mail;
    }
    public  String Getaddress(){
        return this.address;
    }
    public String Getqq(){
        return this.qq;
    }
    public void Setname(String name){this.name = name;}
}
