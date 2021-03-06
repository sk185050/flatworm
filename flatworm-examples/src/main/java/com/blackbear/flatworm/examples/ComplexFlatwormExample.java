/*
 * Flatworm - A Java Flat File Importer/Exporter Copyright (C) 2004 James M. Turner.
 * Extended by James Lawrence 2005
 * Extended by Josh Brackett in 2011 and 2012
 * Extended by Alan Henson in 2016
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.blackbear.flatworm.examples;

import com.blackbear.flatworm.FileFormat;
import com.blackbear.flatworm.MatchedRecord;
import com.blackbear.flatworm.config.ConfigurationReader;
import com.blackbear.flatworm.config.impl.DefaultConfigurationReaderImpl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ComplexFlatwormExample {
    public static void main(String[] args) {
        ConfigurationReader parser = new DefaultConfigurationReaderImpl();
        try {
            FileFormat ff = parser.loadConfigurationFile(args[0]);
            InputStream in = new FileInputStream(args[1]);
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(in));

            MatchedRecord results;
            while ((results = ff.nextRecord(bufIn)) != null) {
                if (results.getRecordName().equals("dvd")) {
                    System.out.println(results.getBean("dvd"));
                    System.out.println(results.getBean("film"));
                }
                if (results.getRecordName().equals("videotape")) {
                    System.out.println(results.getBean("video"));
                    System.out.println(results.getBean("film"));
                }
                if (results.getRecordName().equals("book")) {
                    System.out.println(results.getBean("book"));
                }
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
