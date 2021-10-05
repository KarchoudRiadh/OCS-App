package rk.mk.ocs_demo.data

import java.io.Serializable

class SelectedShow : Serializable {
    var imageUrl: String
    var title: String
    var subtitle: String
    var description: String

    constructor(imageUrl: String, title: String, subtitle: String, description: String) {
        this.imageUrl = imageUrl
        this.title = title
        this.subtitle = subtitle
        this.description = description
    }

    override fun toString(): String {
        return "SelectedShow(imageUrl='$imageUrl', title='$title', subtitle='$subtitle', description='$description')"
    }


}