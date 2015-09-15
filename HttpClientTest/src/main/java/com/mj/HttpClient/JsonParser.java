package com.mj.HttpClient;


import com.google.common.collect.Lists;
import com.google.gson.Gson;
import java.util.List;

public class JsonParser {

    public void parser(){
        Gson gson=new Gson();
        A mjun = new A("mjun", "1", Lists.newArrayList(new B("s","1"),new B("c","2"),new B("l","3"),new B("g","4")));
        String s = gson.toJson(mjun);
        System.out.println(s);

    }


    public  static void main(String[]args){
        new JsonParser().parser();
    }

    class A{
        String name;
        String id;
        List<B> list;

        A(String name,String id, List list){
            this.name=name;
            this.id=id;
            this.list=list;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<B> getList() {
            return list;
        }

        public void setList(List<B> list) {
            this.list = list;
        }
    }
    class B{
        String nameStr;
        String id;
        B(String name,String id){
            this.nameStr=name;
            this.id=id;
        }
    }
}
