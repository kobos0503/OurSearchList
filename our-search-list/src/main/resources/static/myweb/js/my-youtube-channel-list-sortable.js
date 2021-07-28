sortable('.js-grid', {
	forcePlaceholderSize: true,
	placeholderClass: 'col col-4 border border-maroon'
});
sortable('.js-sortable-connected', {
	forcePlaceholderSize: true,
	connectWith: '.js-connected',
	handle: '.js-handle',
	items: 'li',
	placeholderClass: 'border border-white bg-orange mb1'
});
sortable('.js-sortable-inner-connected', {
	forcePlaceholderSize: true,
	connectWith: 'js-inner-connected',
	handle: '.js-inner-handle',
	items: '.item',
	maxItems: 3,
	placeholderClass: 'border border-white bg-orange mb1'
});
document.querySelector('.js-sortable-connected').addEventListener('sortupdate', function(e) {
	console.log('Sortupdate: ', e.detail);
	console.log('Container: ', e.detail.origin.container, ' -> ', e.detail.destination.container);
	console.log('Index: ' + e.detail.origin.index + ' -> ' + e.detail.destination.index);
	console.log('Element Index: ' + e.detail.origin.elementIndex + ' -> ' + e.detail.destination.elementIndex);
});

document.querySelector('.js-sortable-connected').addEventListener('sortstart', function(e) {
	console.log('Sortstart: ', e.detail);
});

document.querySelector('.js-sortable-connected').addEventListener('sortstop', function(e) {
	console.log('Sortstop: ', e.detail);
});