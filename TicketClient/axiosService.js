import axios from 'axios'

var baseUrl = 'http://localhost:8075/TicketServer/'
const axiosService = axios.create({
  baseURL: baseUrl
})

export default axiosService
