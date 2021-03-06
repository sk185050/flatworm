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

/*
 * Created on Apr 5, 2005
 * 
 * To change the template for this generated file go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and
 * Comments
 */
package com.blackbear.flatworm.examples;

import com.blackbear.flatworm.test.domain.Book;
import com.blackbear.flatworm.test.domain.Dvd;
import com.blackbear.flatworm.test.domain.Film;
import com.blackbear.flatworm.test.domain.Inventory;
import com.blackbear.flatworm.test.domain.Videotape;

/**
 * @author e50633
 *
 *         To change the template for this generated converterName comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and
 *         Comments
 */
public final class InventoryFactory {
    public static Inventory getInventoryFor(Dvd dvd, Film film) {
        Inventory inventory = new Inventory();

        inventory.setPrice(dvd.getPrice());
        inventory.setDescription(film.getTitle() + " - (" + film.getStudio() + ")");
        inventory.setQuantity(0);
        inventory.setSku(dvd.getSku());

        return inventory;
    }

    public static Inventory getInventoryFor(Videotape video, Film film) {
        Inventory inventory = new Inventory();

        inventory.setPrice(video.getPrice());
        inventory.setDescription(film.getTitle() + " - (" + film.getStudio() + ")");
        inventory.setQuantity(10);
        inventory.setSku(video.getSku());

        return inventory;
    }

    public static Inventory getInventoryFor(Book book) {
        Inventory inventory = new Inventory();

        inventory.setPrice(book.getPrice());
        inventory.setDescription(book.getTitle() + " by " + book.getAuthor());
        inventory.setQuantity(5);
        inventory.setSku(book.getSku());

        return inventory;
    }
}
