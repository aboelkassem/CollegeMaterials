import numpy as np
import cv2  

img = cv2.imread('./apple.jpg' , 0)

#Intstance of SIFT algorithm 
sift = cv2.xfeatures2d.SIFT_create()

#Intstance of SURF algorithm 
#surf = cv2.xfeatures2d.SURF_create()

#Intstance of ORB algorithm
orb = cv2.ORB_create()


#Replace the sift wiith surf , orb

keyPoints , descriptors = sift.detectAndCompute(img , None)
img = cv2.drawKeypoints(img, keyPoints, None)

cv2.imshow("Image" , img)

cv2.waitKey(0)
cv2.destroyAllWindows()