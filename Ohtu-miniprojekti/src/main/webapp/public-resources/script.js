function displayForm(index) {
    jQuery('.forms>div').addClass('hidden').eq(index).removeClass('hidden')
    jQuery('.formDrop option').eq(index).prop('selected',true)
}

jQuery(function($){
    
    $('.formDrop').change(function(){
        var index = $(this).find(':selected').index()
        displayForm(index)
        window.sessionStorage['index'] = index
    })

    displayForm(window.sessionStorage['index']||0)
    $('input:visible:first').focus()


    $(document).easterEgg([77,76,85,85,75, 75,65,73])

    $('.list>div').click(function(){
        $(this).toggleClass('selected')
        var ids = collectIds()
        var url = getBaseHref()+"/"+ids
        $('.generate.human').attr('href',url)
        $('.generate.bibtex').attr('href',url.replace('listIds','downloadIds'))
        $('.generate button').attr('disabled', !ids)


        function getBaseHref(){
           return  $('.generate.human').attr('href').replace(/\/[^/]*$/ , '')
        }
        function collectIds(){
            var string = ""
            $('.selected').each(function(i,elem){
                if (i!=0)
                    string+=","
                string+=$(elem).data('id')
            })
            return string
        }
    })

})
