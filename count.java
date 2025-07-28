 public String getIssueCount(String baseurl,String repoUID,int prID,String sessionId) throws InterruptedException {


        String apiUrl = baseurl + "/api/v1/repositories/" + repoUID + "/pullrequests/" + prID + "/details/" ;
        String bearerToken = values.get("bearerToken");


        if (bearerToken == null || bearerToken.isEmpty()) {
            System.out.println("Error: Bearer token is missing.");
            return null;
        }

        try {
            System.out.println("API url is:" + apiUrl);
            System.out.println(sessionId);
            System.out.println(prID);
            System.out.println(repoUID);
            System.out.println("repoId is :" + repoID);


            Response response = RestAssured.given()
                    .header("Authorization", bearerToken)
                    .contentType("application/json")
                    .queryParam("repositoryId", repoID)
                    .queryParam("sessionId", sessionId)
                    .get(apiUrl);


            System.out.println("response is : " + response.asString());
            //sessionId = response.jsonPath().getString("pullRequests[0].sessionId");

            if (response.getStatusCode() == 200 || response.getStatusCode() == 202) {

                System.out.println("Fetched code issues are : " + sessionId);
            } else {
                System.out.println("Failed to fetch code issues " + response.getStatusCode());
            }
        } catch (Exception e) {
            System.out.println("Exception  " + e.getMessage());
        }
        return null;

    }


/api/v1/repositories/32742fde04a578f7171ebf4ec9127cd9/pullrequests/44/details?repositoryId=9&sessionId=6779b3f1cf6370fbf1fca88e84b4cf2d
