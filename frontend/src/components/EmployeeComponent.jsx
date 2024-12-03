import { useState } from "react"
import { createEmployee } from "../services/EmployeeService"
import { useNavigate } from "react-router-dom"

const EmployeeComponent = () => {

    const [id, setId] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email, setEmail] = useState('')
    const [phone, setPhone] = useState('')
    const [departmentId, setDepartmentId] = useState('')

    const navigator = useNavigate();

    function handleId(e){
        setId(e.target.value);
    }
    
    function handleFirstName(e){
        setFirstName(e.target.value);
    }

    function handleLastName(e){
        setLastName(e.target.value)
    }
    
    function handleEmail(e){
        setEmail(e.target.value)
    }

    function handlePhone(e){
        setPhone(e.target.value)
    }

    function handleDepartmentId(e){
        setDepartmentId(e.target.value)
    }

    function saveEmployee(e){
        e.preventDefault();

        const employee = {id: id || null, firstName, lastName, email, phone, department:{id :departmentId}}
        console.log(employee);

        createEmployee(employee).then((response) => {
            console.log(response.data);
            navigator('/employees')
        })
    }


    return (
        <div className="container">
            <br /><br />
            <div className="row">
                <div className="card col-md-6 offset-md-3 offset-md-3">
                    <h2 className="text-center">Add Employee </h2>
                    <div className="card-body">
                        <form>

                        <div className="form-group mb-2">
                                <label className="form-label">Employee ID</label>
                                <input
                                    type="text"
                                    placeholder="Enter Employee ID"
                                    name="id"
                                    value={id}
                                    className="form-control"
                                    onChange={handleId}
                                />
                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">First Name</label>
                                <input
                                    type="text"
                                    placeholder="Enter Employee First Name"
                                    name="firstName"
                                    value={firstName}
                                    className="form-control"
                                    onChange={handleFirstName}
                                >
                                </input> 

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Last Name</label>
                                <input
                                    type="text"
                                    placeholder="Enter Employee Last Name"
                                    name="lastName"
                                    value={lastName}
                                    className="form-control"
                                    onChange={handleLastName}
                                >
                                </input> 

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Email</label>
                                <input
                                    type="text"
                                    placeholder="Enter Employee Email"
                                    name="email"
                                    value={email}
                                    className="form-control"
                                    onChange={handleEmail}
                                >
                                </input> 

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Phone</label>
                                <input
                                    type="text"
                                    placeholder="Enter Phone"
                                    name="phone"
                                    value={phone}
                                    className="form-control"
                                    onChange={handlePhone}
                                >
                                </input> 

                            </div>

                            <div className="form-group mb-2">
                                <label className="form-label">Department Id</label>
                                <input
                                    type="text"
                                    placeholder="Enter Department Id"
                                    name="departmentId"
                                    value={departmentId}
                                    className="form-control"
                                    onChange={handleDepartmentId}
                                >
                                </input> 

                            </div>
                            <button className="btn btn-success" onClick={saveEmployee}>Submit</button>

                        </form>

                    </div>

                </div>


            </div>

        </div>
    )
}

export default EmployeeComponent