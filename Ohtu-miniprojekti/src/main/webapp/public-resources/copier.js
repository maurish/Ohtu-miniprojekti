(function($){
    $.fn.easyCopy = function(){
        var $this = $(this)
        $this.on('click', function(){
            $this.select()
        })
        $this.select()
        
        
        
        $this.on('change', function(){
            var oldH = $this.height()
            $this.height(0)
            var scrollheight = $this[0].scrollHeight||0
            var paddingTop = parseInt($this.css('padding-top'))||0
            var paddingBottom = parseInt($this.css('padding-bottom'))||0
            var height =  scrollheight- (paddingTop+paddingBottom)
            $this.height(oldH)
            $this.animate({
                'height':height
            },200)
        })
        
        $this.trigger('change')
        
        return this
    }
    
    
    $.fn.fontResize = function(elem){
        $(this).click(function(){
            var $this = $(this)
            if (elem.is(':animated') || $(this).is(':animated') )return
            var font =  parseInt(elem.css('font-size'));
            if ($(this).hasClass('plus')){
                font +=3
            }else{
                font-=3
            }
            elem.animate({
                'font-size': font
            },200 ,function(){
                elem.trigger('change')
            })
        })
    }




    $.fn.easterEgg = function(codes){
        var $this = $(this)
        var index =0
        $this.keyup(function(e){
            
            if (codes[index]==e.which){
                if (++index >=codes.length){
                    $('body').toggleClass('easter')
                    index=0
                }
            }else{
                index=0
            }
        })
        return $this;
    }

    $.fn.hideBySelection = function(){
        var $this = $(this)
        var textbox = $this.find(':text')
        var checkbox = $this.find(':checkbox')
        textbox.keyup(function(e){
            showSelected()
        })
        checkbox.change(function(e){
            showSelected()
        })
        function showSelected(){
            var data = textbox.val()
            if (checkbox.is(':checked'))data=data.toLowerCase()
            console.log(data)
            if(!data){
                showAll();
            }
            $('.list>.ref').each(function(i, elem){
                var html = $(this).html()
                if (checkbox.is(':checked'))html=html.toLowerCase()
                if (html.indexOf(data)!==-1 || $(this).hasClass('selected')){
                    //$(this).removeClass('hidden')
                    $(this).slideDown()
                }else{
                    //$(this).addClass('hidden')
                    $(this).slideUp()
                }
            })
        }
        function showAll(){
            $('.list>.ref').removeClass('hidden')
        }
    }
}
    
)(jQuery)