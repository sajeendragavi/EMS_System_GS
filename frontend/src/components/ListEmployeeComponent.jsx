import React, { useEffect, useState } from "react";
import { listEmployees } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";

const ListEmployeeComponent = () => {
    const [employees, setEmployees] = useState([]);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);

    const navigate = useNavigate();

    useEffect(() => {
        listEmployees(0, 10) // Assuming page=0 and size=10 by default
            .then((response) => {
                setEmployees(response.data.content); // Adjust to match your API response
                setError(null);
            })
            .catch((error) => {
                console.error("Error fetching employees:", error);
                setError("Failed to fetch employees.");
            })
            .finally(() => {
                setLoading(false);
            });
    }, []);

    const addNewEmployee = () => {
        navigate("/add-employee");
    };

    return (
        <div className="container">
            <button className="btn btn-primary mb-2" onClick={addNewEmployee}>
                Add Employee
            </button>
            <h2>List of Employees</h2>
            {loading ? (
                <p>Loading employees...</p>
            ) : error ? (
                <p className="text-danger">{error}</p>
            ) : employees.length > 0 ? (
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th>Employee Id</th>
                            <th>Employee First Name</th>
                            <th>Employee Last Name</th>
                            <th>Employee Email Id</th>
                            <th>Employee Phone</th>
                            <th>Employee Department</th>
                        </tr>
                    </thead>
                    <tbody>
                        {employees.map((employee) => (
                            <tr key={employee.id}>
                                <td>{employee.id}</td>
                                <td>{employee.firstName}</td>
                                <td>{employee.lastName}</td>
                                <td>{employee.email}</td>
                                <td>{employee.phone || "N/A"}</td>
                                <td>{employee.department.name || "N/A"}</td>
                            </tr>
                        ))}
                    </tbody>
                    
                </table>
            ) : (
                <p>No employees found.</p>
            )}
        </div>
    );
};

export default ListEmployeeComponent;


// import React, { useEffect, useState } from 'react';
// import { listEmployees } from '../services/EmployeeService';
// import { useNavigate } from 'react-router-dom';

// const ListEmployeeComponent = () => {
//     const [employees, setEmployees] = useState([]);
//     const [error, setError] = useState(null);

//     const navigator = useNavigate(); 

//     useEffect(() => {
//         listEmployees()
//             .then((response) => {
//                 // Accessing the 'content' array in the paginated response
//                 setEmployees(response.data.content);
//             })
//             .catch((error) => {
//                 console.error(error);
//                 setError('Failed to fetch employees.');
//             });
//     }, []);

//     function addNewEmployee(){
//         navigator('/add-employee')
//     }

//     return (
//         <div className="container">
//             <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee </button>
//             <h2>List of Employees</h2>
//             {error && <p className="text-danger">{error}</p>}
//             <table className="table table-striped table-bordered">
//                 <thead>
//                     <tr>
//                         <th>Employee Id</th>
//                         <th>Employee First Name</th>
//                         <th>Employee Last Name</th>
//                         <th>Employee Email Id</th>
//                         <th>Employee Phone</th>
//                         <th>Employee Department</th>
//                     </tr>
//                 </thead>
//                 <tbody>
//                     {employees.length > 0 ? (
//                         employees.map((employee) => (
//                             <tr key={employee.id}>
//                                 <td>{employee.id}</td>
//                                 <td>{employee.firstName}</td>
//                                 <td>{employee.lastName}</td>
//                                 <td>{employee.email}</td>
//                                 <td>{employee.phone}</td>
//                                 <td>{employee.department}</td>
//                             </tr>
//                         ))
//                     ) : (
//                         <tr>
//                             <td colSpan="4" className="text-center">
//                                 No employees found.
//                             </td>
//                         </tr>
//                     )}
//                 </tbody>
//             </table>
//         </div>
//     );
// };

// export default ListEmployeeComponent;



// // import React, {useEffect, useState} from 'react'
// // import { listEmployees } from '../services/EmployeeService';

// // const ListEmployeeComponent = () => {

// //     const [employees, setEmployees] = useState([]);

// //     useEffect(() => {
// //         listEmployees().then((response) => {
// //             setEmployees(response.data);
// //         }).catch(error => {
// //             console.error(error);
// //             setError("Failed to fetch employees");
// //         })

// //     }, []);

// //   return (
// //     <div className='container'>
// //        <h2>List of Employees</h2>
// //        <table className='table table-striped table-bordered'>
       
// //             <thead>
// //                 <tr>
// //                     <th>Employee Id</th>
// //                     <th>Employee First Name</th>
// //                     <th>Employee Last Name</th>
// //                     <th>Employee Email Id</th>

// //                 </tr>

// //             </thead>

// //             <tbody>
// //                 {
// //                     employees.map(employee => 
// //                         <tr key = {employee.id}>
// //                             <td>{employee.id}</td>
// //                             <td>{employee.firstName}</td>
// //                             <td>{employee.lastName}</td>
// //                             <td>{employee.email}</td>
// //                         </tr>)

// //                 }

// //             </tbody>

// //        </table>
        
        
    
// //     </div>


// //   )
// // }

// // export default ListEmployeeComponent