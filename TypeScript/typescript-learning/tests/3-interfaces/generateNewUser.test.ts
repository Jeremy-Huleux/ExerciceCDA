import { describe, it, expect } from 'vitest'
import { generateNewUser } from '../../functions/3-interfaces'

describe('generateNewUser', () => {
  it('retourne un objet \'User\'', () => {
    expect(typeof generateNewUser('John')).toBe('object')
  })

  it('renvoie un objet avec les propriétés attendues', () => {
    const user = generateNewUser('John')
    expect(user.name).toBe('John')
    expect(user.verified).toBe(false)
    expect(user.picture).toBeUndefined()
    expect(user.email).toBeUndefined()
  })
})
