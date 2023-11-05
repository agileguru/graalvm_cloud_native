# Cloud Run multiple containers in one deployment

## Deploy multi container app 
> gcloud run services replace service.yaml

> gcloud run services set-iam-policy multi-container-example policy.yaml

## Deploy single container app
> gcloud run services replace server.yaml

> cloud run services set-iam-policy server-only-example policy.yaml

## Delete app
>  gcloud run services delete multi-container-example

> gcloud run services delete server-only-example
