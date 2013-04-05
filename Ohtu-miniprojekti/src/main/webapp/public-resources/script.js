function displayForm(index) {
    jQuery('div').addClass('hidden').eq(index).removeClass('hidden')
}

jQuery(function(){
    jQuery('.formDrop option').click(function() {
        displayForm(jQuery(this).index())
    })
    displayForm(0)
})