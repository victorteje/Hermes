import http from "../http-common";

class GuideDataService {
  getAll() {
    return http.get(`/guides`);
  }

  get(id) {
    return http.get(`/guides/${id}`);
  }

  create(data) {
    return http.post(`/guides`, data);
  }

  update(id, data) {
    return http.put(`/guides/${id}`, data);
  }

  delete(id) {
    return http.delete(`/guides/${id}`);
  }

  getByDestination(destination) {
    return http.get(`/guides/search?keyword=${destination}`);
  }
}

export default new GuideDataService();
