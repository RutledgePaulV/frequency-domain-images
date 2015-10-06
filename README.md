### Frequency Domain
The frequency domain is a means of representing objects which contain periodic behavior. The brightness and texture
of an image can be represented as a fourier series (combinations of periodic trigonometric functions of varying
amplitudes and phase shifts). Doing so allows grouping the information that makes up an image in new formats, some
of which prove convenient for certain purposes such as filtering out things with periodic tendencies, including
some common distortions. For a more in depth intro to the topic [look here](https://www.cs.auckland.ac.nz/courses/compsci773s1c/lectures/ImageProcessing-html/topic1.htm).


### What is this?
A naive implementation of the fast fourier transform I wrote during college along with some conversions that map images from their 
native spatial domain into the frequency domain and back again. Additionally, you can zero out portions of the frequency-domain representation
by clicking on them, and those values are used to regenerate the result of mapping back to the spatial domain from the frequency domain. 
Doing so permits you to see the effects of filtering in the frequency domain.


### Image:
- Left: image in the original state
- Middle: Frequency domain representation. Black boxes indicate regions that were "zeroed" by clicking on them
- Right: The transformation of the current middle representation back into the frequency domain.


<img src="https://lh3.googleusercontent.com/AV5OL-i5CgClfmwayDcp45NieGJeZt5z4ZWOdwty83KAnRGEfKjq5_4QPjZRHRPypzPYs64V6w0j
GCWlVHmFjVz1qT9z5tUtzpSz4N1GoQ4tv0G4wDcnaLoXGUleBcHvWiK51FsMS4rpwp2PCItVT-iUq1K-wSM48yXIVNS9_tAzeF1T1gPccanRkhupLSpjGtV8
Shx3hg9Ij4lUxMNcRpQ2Y50WGKUCFwNzBA1zQxCNSzAIcNZKsoS9nFsvz8zOiMErYp36KGEH0hN-e3wM5TEU4PaA8ayo5lnyDfsqYtRUBL_UewQODOiNZ_G-
tOvVDnZGnDD1HRr9ZDv5vCXP9huWsPbtdGUcO-hziK-brOcZPXYSSnqrniAQim-hj7eBDRBvQ9TEjcF6LJr8T6OQxOq1cJgk0XZV34pPbsU-EazVvFaljSnb
7BHhEpBiC8lAnymZDE7Wm0iKgIyEZmgkkqF1m34ys_Y-qJscRDO8DCF_2rzAGHTdwHu7ALfmAeR7yJ0G5UT0LL6izGjO7D5tWI023-CkZwiyut6fqB2zyiY=
w1632-h586-no"/>


As you can see, zeroing the easily identifiable few bright spots that exist outside of the origin in the frequency domain 
allowed us to target and remove the periodic distortions that existed on the original image while maintaining the other 
characteristics of the image.