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
}
    
)(jQuery)