/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class APosAExpr extends PAExpr
{
    private TPlusOp _plusOp_;
    private PAExpr _aExpr_;

    public APosAExpr()
    {
        // Constructor
    }

    public APosAExpr(
        @SuppressWarnings("hiding") TPlusOp _plusOp_,
        @SuppressWarnings("hiding") PAExpr _aExpr_)
    {
        // Constructor
        setPlusOp(_plusOp_);

        setAExpr(_aExpr_);

    }

    @Override
    public Object clone()
    {
        return new APosAExpr(
            cloneNode(this._plusOp_),
            cloneNode(this._aExpr_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPosAExpr(this);
    }

    public TPlusOp getPlusOp()
    {
        return this._plusOp_;
    }

    public void setPlusOp(TPlusOp node)
    {
        if(this._plusOp_ != null)
        {
            this._plusOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._plusOp_ = node;
    }

    public PAExpr getAExpr()
    {
        return this._aExpr_;
    }

    public void setAExpr(PAExpr node)
    {
        if(this._aExpr_ != null)
        {
            this._aExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._aExpr_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._plusOp_)
            + toString(this._aExpr_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._plusOp_ == child)
        {
            this._plusOp_ = null;
            return;
        }

        if(this._aExpr_ == child)
        {
            this._aExpr_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._plusOp_ == oldChild)
        {
            setPlusOp((TPlusOp) newChild);
            return;
        }

        if(this._aExpr_ == oldChild)
        {
            setAExpr((PAExpr) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
