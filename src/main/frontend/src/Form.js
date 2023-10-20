import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
function Form() {
  const { id } = useParams();
  const [employee, setEmployee] = useState({
    firstName: '',
    lastName: '',
    email: '',
  });
  const navigate = useNavigate();

  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setEmployee({ ...employee, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(employee),
    };
    fetch('http://localhost:8080/apis/employees', requestOptions);
    navigate('/');
    navigate(0);
  };
  useEffect(() => {
    if (id) {
      fetch(`http://localhost:8080/apis/employees/${id}`)
        .then((response) => response.json())
        .then((employee) => setEmployee(employee));
    }
  }, [id]);
  return (
    <div>
      <form action=''>
        <div>
          <label htmlFor='firstName'>First Name: </label>
          <input
            type='text'
            id='firstName'
            name='firstName'
            value={employee.firstName}
            onChange={handleChange}
          />
          <br />
        </div>
        <div>
          <label htmlFor='lastName'>Last Name:</label>
          <input
            type='text'
            id='lastName'
            name='lastName'
            value={employee.lastName}
            onChange={handleChange}
          />
          <br />
        </div>
        <div>
          <label htmlFor='email'>Email: </label>
          <input
            type='text'
            id='email'
            name='email'
            onChange={handleChange}
            value={employee.email}
          />
          <br />
        </div>
        <button type='submit' onClick={handleSubmit}>
          Submit
        </button>
        <br />
        <Link to='/'>
          <button>To home</button>
        </Link>
      </form>
    </div>
  );
}

export default Form;
