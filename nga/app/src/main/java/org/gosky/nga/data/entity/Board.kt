package org.gosky.nga.data.entity

class Board @JvmOverloads constructor(
        /**
         * @return the category
         */
        /**
         * @param category the category to set
         */
        var category: Int = 0, var url: String? = "0", var name: String? = "invalid", var icon: Int = 0) {


    constructor(url: String, name: String, icon: Int) : this(0, url, name, icon) {}


    constructor(url: String, name: String) : this(0, url, name, 0) {}


}
