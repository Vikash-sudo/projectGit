package com.github.qa.utils;

import org.testng.annotations.DataProvider;

import com.github.qa.base.TestBase;
public class DataproviderClass extends TestBase{
        @DataProvider(name="SearchProvider")
        public static Object[][] getDataFromDataprovider(){
            return new Object[][] {
                { prop.getProperty("issueTitle1"), prop.getProperty("issueDescritpion") },
                { prop.getProperty("issueTitle2") + " #1", prop.getProperty("issueDescritpion") + " #1"}
            };  
}}
