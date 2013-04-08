function displayForm(index) {
    jQuery('div').addClass('hidden').eq(index).removeClass('hidden')
}

jQuery(function(){
    
    jQuery('.formDrop').change(function(){
        displayForm($(this).find(':selected').index())
    })

    displayForm(0)
})