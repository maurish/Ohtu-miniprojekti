function displayForm(index) {
    jQuery('.forms>div').addClass('hidden').eq(index).removeClass('hidden')
    jQuery('.formDrop option').eq(index).prop('selected',true)
}

jQuery(function(){
    
    jQuery('.formDrop').change(function(){
        var index = $(this).find(':selected').index()
        displayForm(index)
        window.sessionStorage['index'] = index
    })

    displayForm(window.sessionStorage['index']||0)

    jQuery('body').easterEgg([77,76,85,85,75, 75,65,73])
})

