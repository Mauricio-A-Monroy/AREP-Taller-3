package edu.escuelaing.arep.microspring.http;

class HttpRequest {
    private String path = null;
    private String query = null;
    public HttpRequest(String path, String query){
        this.path = path;
        this.query = query;

    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }
    public String getValues(String var){
        if (query == null || query.isEmpty()) {
            return null; // No hay parámetros
        }
        String[] pairs = query.split("&"); // Divide cada "clave=valor"
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2 && keyValue[0].equals(var)) {
                return keyValue[1]; // Devuelve el valor si coincide la clave
            }
        }
        return null;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }
}

