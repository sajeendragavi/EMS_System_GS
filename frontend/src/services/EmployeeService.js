import axios from "axios";

// Define base URL and create an Axios instance
const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

const axiosInstance = axios.create({
  baseURL: REST_API_BASE_URL,
  auth: {
    username: "empadmin",
    password: "exam#123",
  },
  withCredentials: true,
});

export default axiosInstance;

// Function to list employees with pagination
export const listEmployees = (page = 0, size = 10) => {
  return axiosInstance.get("", {
    params: {
      page: page,
      size: size,
    },
  });
};

// Function to create a new employee
export const createEmployee = (employee) => {
    return axiosInstance.post("",employee);
            
};


// export const createEmployee = (employee) => {
//   return axiosInstance.post("", employee);
// };

// Example usage
listEmployees(1, 2)
  .then(response => {
    console.log("Employees:", response.data);
  })
  .catch(error => {
    console.error("Error fetching employees:", error);
  });

// createEmployee({
//   name: "Jane Doe",
//   position: "Manager",
//   department: "Sales",
// })
//   .then(response => {
//     console.log("Employee created:", response.data);
//   })
//   .catch(error => {
//     console.error("Error creating employee:", error);
//   });



// import axios from "axios";

// const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

// //axios.get("http://localhost:8080/api/employees",{
// const axiosInstance = axios.create({
//     baseURL : REST_API_BASE_URL,
//     auth:{
//         username: "empadmin",
//         password: "exam#123"
//     },
//     withCredentials: true
// });
    
// export default axiosInstance

// //fucntion to list employees with pagination
// export const listEmployees = (page = 0, size = 10) => {
//     return axiosInstance.get("",{
//         params: {
//             page : page,
//             size : size
//         }
//     });
// };

// //example usage
// listEmployees(1,2)
// .then(response => {
//     console.log("Employees:",response.data);
// })
// .catch(error => {
//     console.error("Error fetching employees:", error);
// });

// export const createEmployee = (employee) => axios.post({
//     baseURL:REST_API_BASE_URL,
//     auth:{
//         username: "empadmin",
//         password: "exam#123"
//     },
//     withCredentials: true
// });
    

// // .then(response => {
// //     console.log(response.data);
// // })
// // .catch(error => {
// //     console.error(error);
// // })

// // export const listEmployees = () => {
// //     return axios.get(REST_API_BASE_URL);
// // }

