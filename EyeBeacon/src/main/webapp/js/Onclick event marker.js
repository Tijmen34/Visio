var myCenter = new google.maps.LatLng(53, -1.33);

function initialize()
{
var mapProp = {
    center:myCenter,
    zoom: 14,
    draggable: false,
    scrollwheel: false,
    mapTypeId:google.maps.MapTypeId.ROADMAP
};

var map=new google.maps.Map(document.getElementById("map-canvas"),mapProp);

var marker=new google.maps.Marker({
    position:myCenter,
    icon:'images/pin.png',
    url: 'http://www.google.com/',
    animation:google.maps.Animation.DROP
});
marker.setMap(map);
}

google.maps.event.addDomListener(window, 'load', initialize);