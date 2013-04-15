(function($){
    $.fn.easyCopy = function(){
        var $this = $(this)
        $this.on('click', function(){
            $this.select()
        })
        $this.select()
        
        
        var scrollheight = $this[0].scrollHeight||0
        var paddingTop = parseInt($this.css('padding-top'))||0
        var paddingBottom = parseInt($this.css('padding-bottom'))||0
        var height =  scrollheight- (paddingTop+paddingBottom)
        $this.css('height',height)
        
        
        return this
    }
    
    
    
    
})(jQuery)