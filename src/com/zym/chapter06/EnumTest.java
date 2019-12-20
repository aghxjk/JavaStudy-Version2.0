package com.zym.chapter06;

/**
 * Created by zhaoyimeng on 15/11/24.
 */
public class EnumTest {

    public static RetVal  divide(int a, int b){

        try {
            int c = b / a;
            System.out.println(c);
            return RetVal.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RetVal.FAIL;

    }


    public static void test_1(){

        System.out.println("---------------->枚举类型:");
        int a = 10;
        int b = 10;

        RetVal retVal = divide(a, b);

        if (retVal == RetVal.SUCCESS){
            System.out.println("Enum test: Success");
        } else {
            System.out.println("Enum test: Failed");
        }
    }

    public static void test_2(){
        System.out.println("---------------------");
        for (Season season:Season.values()){
            System.out.println(season.toString() + " " + season.ordinal());
        }

        System.out.println("---------------------");
        for (Week week:Week.values()){
            System.out.println(week.getDay() + " " + week.getIndex());
        }
        System.out.println(Week.MON.getDay() + " : " + Week.MON.getIndex());
    }
}

enum RetVal{

    //成功,失败
    SUCCESS,FAIL
}

enum Season{

    SPRING,SUMMER,AUTUMN,WINTER
}

enum Week{

    MON("Monday", 1),
    TUE("Tuesday", 2),
    WED("Wednesday", 3),
    THU("Thursday", 4),
    FRI("Friday", 5),
    SAT("Saturday", 6),
    SUN("Sunday", 7);

    String day;
    int index;

    Week(String today, int index) {
        this.day = today;
        this.index = index;
    }

    public String getDay() {
        return day;
    }

    public int getIndex() {
        return index;
    }
}