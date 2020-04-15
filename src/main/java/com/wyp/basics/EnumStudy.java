package com.wyp.basics;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class EnumStudy {
    @Getter
    enum SeasonEnum{
        SPRING(1, "spring");
        private int seq;
        private String desc;
        SeasonEnum(int seq, String desc){
            this.seq = seq;
            this.desc = desc;
        }

        public static String getDesc(int seq){
            for (SeasonEnum t : SeasonEnum.values()){
                if (t.getSeq() == seq){
                    return t.getDesc();
                }
            }
            return null;
        }
    }
    public static void main(String[] args){

        System.out.println(SeasonEnum.getDesc(1));
        System.out.println(SeasonEnum.SPRING.toString());
    }
}
