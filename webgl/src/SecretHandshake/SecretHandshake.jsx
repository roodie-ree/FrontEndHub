import { debounce, pick } from 'lodash'
import React, { isValidElement, useEffect, useState } from 'react'

const getHandshake = debounce((number, setHandshake) => {
  if (number.trim() === '') {
    return setHandshake(null)
  }
  const shakeNumber = Number.parseInt(number, 10)

  if (Number.isNaN(shakeNumber) || shakeNumber < 1 || shakeNumber > 31) {
    return setHandshake(
      <>Error: <strong>{number}</strong> is not a valid Handshake</>
    )
  }
  const ctrl = new AbortController()

  fetch(`http://localhost:5678/handshake?number=${number}`, pick(ctrl, 'signal'))
    .then(response => response.json())
    .then(result => setHandshake(result))
    .catch(error => {
      if (error.message.includes('aborted')) {
        return
      }
      setHandshake(
        <>Error fetching handshake <strong>{number}</strong>: {error.toString()}</>
      )
    })

  return () => ctrl.abort()
}, 500)

const SecretHandshake = function SecretHandshake (props) {
  const [ number, setNumber ] = useState(props.initial || '')
  const [ handshake, setHandshake ] = useState(null)

  useEffect(() => getHandshake(number, setHandshake), [ number ])

  let handshakeList = null

  if (isValidElement(handshake)) {
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
          type='text'
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
