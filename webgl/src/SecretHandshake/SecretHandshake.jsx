import React, { useEffect, useState } from 'react'

const SecretHandshake = function SecretHandshake (props) {
  const [ number, setNumber ] = useState(props.initial || '')
  const [ handshake, setHandshake ] = useState(null)

  useEffect(() => {
    const shakeNumber = Number.parseInt(number, 10)

    if (Number.isNaN(shakeNumber) || shakeNumber < 1 || shakeNumber > 31) {
      return setHandshake(null)
    }
    fetch(`http://localhost:5678/handshake?number=${number}`)
      .then(response => response.json())
      .then(result => setHandshake(result))
      .catch(error => {
        setHandshake(`Error fetching handshake ${number}: ${error}`)
      })
  }, [ number ])

  let handshakeList = null

  if (typeof handshake === 'string') {
    handshakeList = (
      <div className='alert alert-warning'>
        {handshake}
      </div>
    )
  } else if (Array.isArray(handshake)) {
    const handshakeSteps = handshake.map(shake => (
      <li className='list-group-item' key={ shake }>
        {shake}
      </li>
    ))

    handshakeList = (
      <>
        <label>Secret Handshake</label>
        <ul className='list-group'>
          {handshakeSteps}
        </ul>
      </>
    )
  }

  return (
    <form>
      <div className='form-group'>
        <label>Handshake number</label>
        <input
          className='form-control'
          type='number'
          value={ number }
          onChange={ event => setNumber(event.target.value) }
        />
      </div>
      <div className='form-group'>
        {handshakeList}
      </div>
    </form>
  )
}

export default SecretHandshake
