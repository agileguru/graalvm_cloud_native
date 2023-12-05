# graalvm_cloud_native
Spring Boot Application Using GraalVM and Best practice for cloud native tech 

## How To Test
for i in `seq 1 100`; do curl https://nepadoitguru.demo.agileguru.org ; echo "\n"; done


## Client Side 
kubectl describe service server-service -n dev
kubectl get service client-service -n dev -o yaml

## Server Side 

kubectl describe service server-service -n dev
kubectl get service server-service -n dev -o yaml