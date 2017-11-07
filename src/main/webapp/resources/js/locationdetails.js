 function  substringMatcher(strs) {
    return function findMatches(q, cb) {
        var matches, substringRegex;

        // an array that will be populated with substring matches
        matches = [];

        // regex used to determine if a string contains the substring `q`
        substrRegex = new RegExp(q, 'i');

        // iterate through the pool of strings and for any string that
        // contains the substring `q`, add it to the `matches` array
        $.each(strs, function(i, str) {
            if (substrRegex.test(str)) {
                matches.push(str);
            }
        });

        cb(matches);
    };
};
function loadCountries(countryList) {
        $('#countryDetails .typeahead').typeahead({
                hint: true,
                highlight: true,
                minLength: 1
            },
            {
                name: 'countries',
                limit: 2,
                source: substringMatcher(countryList)
            });
}
function loadProvinces(provinceList) {

        $('#provinceDetails .typeahead').typeahead({
                hint: true,
                highlight: true,
                minLength: 1
            },
            {
                name: 'provinces',
                limit: 2,
                source: substringMatcher(provinceList)
            });
        console.log(provinceList);
}

function loadCitiesAndDistricts(cityAndDistrictList) {

        $('#cityAndDistrictDetails .typeahead').typeahead({
                hint: true,
                highlight: true,
                minLength: 1
            },
            {
                name: 'citiesAndDistricts',
                limit: 2,
                source: substringMatcher(cityAndDistrictList)
            });
        console.log(cityAndDistrictList);
}

 function loadSuburbs(suburbList) {

     $('#suburbDetails .typeahead').typeahead({
             hint: true,
             highlight: true,
             minLength: 1
         },
         {
             name: 'suburbs',
             limit: 2,
             source: substringMatcher(suburbList)
         });
     console.log(suburbList);
 }


