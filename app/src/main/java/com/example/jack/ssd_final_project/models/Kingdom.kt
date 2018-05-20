package com.example.jack.ssd_final_project.models

import java.io.Serializable

class Kingdom(val image : String, val name : String , val reign : String, val doing : String): Serializable {

    override fun toString(): String {
        return image + "\n" +
                name + "\n" +
                reign + "\n" +
                doing + "\n"
    }
}