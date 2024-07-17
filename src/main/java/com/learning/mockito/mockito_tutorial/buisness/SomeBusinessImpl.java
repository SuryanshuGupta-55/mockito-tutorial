package com.learning.mockito.mockito_tutorial.buisness;

public class SomeBusinessImpl {


    private final DataService dataService;
    SomeBusinessImpl(DataService dataService){
        this.dataService = dataService;
    }
    public int findTheGreatestFromAllData(){
        int[] data = dataService.retrieveAllData();
        int grt = Integer.MIN_VALUE;
        for(int value : data){
            grt = Math.max(grt,value);
        }

        return grt;
    }
}

interface DataService{
    int[] retrieveAllData();
}
