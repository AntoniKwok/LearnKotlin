package com.britney.lavenda.digitalentproject.utils

import com.britney.lavenda.digitalentproject.model.Book

interface OnItemClickCallback {
    fun onItemClicked(data: Book)
}
