import { describe, it, expect } from 'vitest'
import { verifyUser } from '../../functions/3-interfaces'

describe('verifyUser', () => {
  const user = {
    name: 'Amy',
    verified: false,
  }
  const actual = verifyUser(user, 'amy@hello.com')

  it('retourne un nouvel objet', () => {
    expect(typeof actual).toBe('object')
    expect(actual).not.toBe(user)
  })

  it('retourne un objet avec les propriétés attendues', () => {
    expect(actual.name).toBe('Amy')
    expect(actual.verified).toBe(true)
    expect(actual.email).toBe('amy@hello.com')
    expect(actual.picture).toBeUndefined()
  })
})
