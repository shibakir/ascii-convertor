# ASCII Art

[![pipeline status](https://gitlab.fit.cvut.cz/BI-OOP/B241/asciiart/badges/master/pipeline.svg)](https://gitlab.fit.cvut.cz/BI-OOP/B241/asciiart)

The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save them. (https://courses.fit.cvut.cz/BI-OOP/projects/ASCII-art.html)

## Exaple commands:

1. `run --image "pic/2.jpg" --rotate +90 --scale 0.25 --invert --table-basic --output-console`
2. `run --image "pic/karel.png" --table-basic --output-file "pic/output"`
3. `run --image "pic/vova.png" --table-pro --output-file "pic/output" --flip x --flip x --rotate 180 --rotate 180`


## Input Supported formats:

1. png
2. jpg
3. jpeg
4. random image  `--image-random`

## Filters (run it the same way as in the Courses examples): 

1. --rotate degrees
2. --invert
3. --flip x or --flip y
4. --brightness value
5. --scale value

## Transformations: 

1. --table-basic
2. --table-advance
3. --table-pro
4. --table-non-linear-basic
5. --custom-table 'your symbols table'

## Output supported formats:

1. Console
2. Some file
